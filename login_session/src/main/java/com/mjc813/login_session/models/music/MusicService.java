package com.mjc813.login_session.models.music;

import com.mjc813.login_session.common.LoginException;
import com.mjc813.login_session.models.member.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MusicService {
	@Autowired
	private MusicJpaRepository musicJpaRepository;

	public MusicDto insert(IMember signedMember, MusicDto insertDto) throws LoginException {
		if ( signedMember == null ) {
			throw new LoginException("is not valid member");
		}
		MusicEntity musicEntity = (MusicEntity)new MusicEntity().copyMembers(insertDto, true);
		musicEntity.setId(null);
		musicEntity.setCreateId(signedMember.getSignId());
		musicEntity.setCreateDt(LocalDateTime.now());
		MusicEntity saved = this.musicJpaRepository.save(musicEntity);
		MusicDto musicDto = (MusicDto)new MusicDto().copyMembers(saved, true);
		return musicDto;
	}

	public MusicDto findById(Long id) {
		MusicEntity musicEntity = this.musicJpaRepository.findById(id).orElseThrow();
		MusicDto find = (MusicDto)new MusicDto().copyMembers(musicEntity, true);
		return find;
	}

	public List<MusicDto> findAll() {
		List<MusicEntity> musicEntities = this.musicJpaRepository.findAll();
		List<MusicDto> result = this.transfer(musicEntities);
		return result;
	}

	private List<MusicDto> transfer(List<MusicEntity> entityList) {
		List<MusicDto> result = entityList.stream().map( item -> (MusicDto)new MusicDto().copyMembers(item, true)).toList();
		return result;
	}
}
