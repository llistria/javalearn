package rhkwp;

import java.time.LocalDate;
import java.util.Objects;

// -------------------- Enum : 동물 종류 --------------------
enum Species {
    CAT, PARROT, LARGE_DOG, SMALL_DOG, RABBIT
}

// -------------------- 주인 --------------------
class Owner {
    private final String name;

    public Owner(String name) { this.name = Objects.requireNonNull(name); }
    public String getName() { return name; }

    // UML: +면회한다(환자) : void
    public void visit(AnimalPatient patient) {
        System.out.printf("[면회] %s 님이 '%s'(%s)을/를 면회했습니다.%n",
                name, patient.getName(), patient.getId());
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return name.equals(owner.name);
    }
    @Override public int hashCode() { return name.hashCode(); }
}

// -------------------- 의사 --------------------
class Doctor {
    private final String name;

    public Doctor(String name) { this.name = Objects.requireNonNull(name); }
    public String getName() { return name; }
}

// -------------------- 동물 환자 --------------------
class AnimalPatient {
    private final String name;          // 이름
    private final Species species;      // 종류
    private final String id;            // 식별번호
    private final LocalDate admissionDate; // 입원날짜
    private Doctor doctor;              // 담당의사
    private LocalDate dischargeDate;    // 퇴원날짜 (없으면 null)
    private final Owner owner;          // 주인
    private int visitCount;             // 면회횟수

    public AnimalPatient(String name, Species species, String id,
                         LocalDate admissionDate, Doctor doctor, Owner owner) {
        this.name = Objects.requireNonNull(name);
        this.species = Objects.requireNonNull(species);
        this.id = Objects.requireNonNull(id);
        this.admissionDate = Objects.requireNonNull(admissionDate);
        this.doctor = Objects.requireNonNull(doctor);
        this.owner = Objects.requireNonNull(owner);
        this.dischargeDate = null;
        this.visitCount = 0;
    }

    // --- getters / setters ---
    public String getName() { return name; }
    public Species getSpecies() { return species; }
    public String getId() { return id; }
    public LocalDate getAdmissionDate() { return admissionDate; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public LocalDate getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(LocalDate dischargeDate) { this.dischargeDate = dischargeDate; }
    public Owner getOwner() { return owner; }
    public int getVisitCount() { return visitCount; }
    public void increaseVisitCount() { this.visitCount++; }

    @Override public String toString() {
        return String.format("%s[%s] id=%s, 주인=%s, 담당의사=%s, 입원=%s, 퇴원=%s, 면회=%d회",
                species, name, id, owner.getName(), doctor.getName(),
                admissionDate, dischargeDate, visitCount);
    }
}

// -------------------- 간호사 --------------------
class Nurse {
    private final String name;
    public Nurse(String name) { this.name = Objects.requireNonNull(name); }
    public String getName() { return name; }

    // UML: +약을준다(환자) : void
    public void giveDrug(AnimalPatient patient) {
        // 실제 투약 로직 대신 로그만 남깁니다.
        System.out.printf("[투약] 간호사 %s → 환자 '%s'(%s)%n",
                name, patient.getName(), patient.getId());
    }

    // UML: +면회허락한다(주인, 환자) : boolean
    public boolean allowVisit(Owner owner, AnimalPatient patient) {
        if (owner == null || patient == null) return false;
        // 규칙: 본인 소유 & 퇴원 전이면 허용
        if (!owner.equals(patient.getOwner())) return false;
        if (patient.getDischargeDate() != null) return false;
        return true;
    }
}

// -------------------- 병원 --------------------
public class Hospital {
    // UML 속성
    private int nowTime;             // 현재시간 : int (임의 시간 단위)
    private final Object[] patients; // 환자들 : Object[]  (실제 원소는 AnimalPatient)
    private final Doctor[] doctors;  // 의사들 : 의사[]
    private Nurse headNurse;         // 주임공간호사 : 간호사

    // 생성자: 병상/의사 수를 고정 용량 배열로 구성
    public Hospital(int patientCapacity, int doctorCapacity, Nurse headNurse) {
        if (patientCapacity <= 0 || doctorCapacity <= 0) {
            throw new IllegalArgumentException("용량은 1 이상이어야 합니다.");
        }
        this.patients = new Object[patientCapacity];
        this.doctors  = new Doctor[doctorCapacity];
        this.headNurse = Objects.requireNonNull(headNurse);
        this.nowTime = 0;
    }

    // --- 보조 메서드 (배열 관리) ---
    private static int firstEmptyIndex(Object[] arr) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == null) return i;
        return -1;
    }
    private static int firstEqualIndex(Object[] arr, Object target) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }

    // 의사 등록
    public boolean addDoctor(Doctor doctor) {
        int idx = firstEmptyIndex(doctors);
        if (idx < 0) return false;
        doctors[idx] = doctor;
        return true;
    }

    // 환자 조회(식별번호로)
    public AnimalPatient findPatientById(String id) {
        for (Object o : patients) {
            if (o instanceof AnimalPatient) {
                AnimalPatient p = (AnimalPatient) o;
                if (p.getId().equals(id)) return p;
            }
        }
        return null;
    }

    // 현재시간 조정(선택)
    public int getNowTime() { return nowTime; }
    public void setNowTime(int nowTime) { this.nowTime = nowTime; }

    public Nurse getHeadNurse() { return headNurse; }
    public void setHeadNurse(Nurse nurse) { this.headNurse = nurse; }

    // ---------------- UML 메서드 ----------------

    /**
     * 입원하다(고양이/앵무새/대형견/소형견/토끼) : boolean
     * - Enum으로 종류를 받습니다.
     * - 의사/주인/이름/식별번호/입원날짜를 함께 받아 환자를 생성하고 첫 빈 칸에 배치합니다.
     */
    public boolean admit(Species species, String petName, String patientId,
                         Owner owner, Doctor doctor, LocalDate admissionDate) {
        int idx = firstEmptyIndex(patients);
        if (idx < 0) return false; // 병상이 가득 찼음

        // 의사가 병원 소속인지 간단히 확인 (선택)
        if (firstEqualIndex(doctors, doctor) < 0) {
            // 소속이 아니면 등록 후 진행 (간단화)
            if (!addDoctor(doctor)) return false;
        }

        AnimalPatient p = new AnimalPatient(petName, species, patientId, admissionDate, doctor, owner);
        patients[idx] = p;
        System.out.printf("[입원] %s (%s, id=%s) 담당의사=%s, 병상=%d%n",
                p.getName(), p.getSpecies(), p.getId(), doctor.getName(), idx);
        return true;
    }

    /**
     * 동물에게 약을준다() : void
     * - 주임 간호사가 현재 입원 중인 모든 환자에게 투약
     */
    public void giveDrugsToAnimals() {
        for (Object o : patients) {
            if (o instanceof AnimalPatient) {
                headNurse.giveDrug((AnimalPatient) o);
            }
        }
    }

    /**
     * 주인이동물을면회한다(주인, 환자) : void
     * - 간호사가 면회 허가를 주면 면회 진행, 환자 면회횟수 증가
     */
    public void arrangeVisit(Owner owner, AnimalPatient patient) {
        if (owner == null || patient == null) return;
        if (headNurse.allowVisit(owner, patient)) {
            owner.visit(patient);
            patient.increaseVisitCount();
        } else {
            System.out.printf("[면회거절] %s → '%s'(%s)%n",
                    owner.getName(), patient.getName(), patient.getId());
        }
    }
}

// -------------------- 사용 예시 --------------------
class MainDemo {
    public static void main(String[] args) {
        Nurse head = new Nurse("김주임");
        Hospital hospital = new Hospital(10, 5, head);

        Doctor drKim = new Doctor("김의사");
        hospital.addDoctor(drKim);

        Owner owner = new Owner("박주인");

        // 입원 (고양이)
        hospital.admit(Species.CAT, "나비", "P-001", owner, drKim, LocalDate.now());

        // 환자 찾기
        AnimalPatient p = hospital.findPatientById("P-001");

        // 면회
        hospital.arrangeVisit(owner, p);

        // 투약
        hospital.giveDrugsToAnimals();
    }
}
