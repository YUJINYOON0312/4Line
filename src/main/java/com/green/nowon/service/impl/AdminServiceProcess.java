package com.green.nowon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;
import com.green.nowon.domain.entity.GoodsEntity;
import com.green.nowon.domain.entity.GoodsEntityRepository;
import com.green.nowon.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceProcess implements AdminService {

	@Autowired
	private GoodsEntityRepository repo;
	
//	@Transactional
	@Override
	public void update(long gno, AdminUpdateDTO dto) {
		System.out.println(">>>>>>>>>>>>수정처리 실행");
//		repo.findById(gno).map(entity->entity.update(dto));
//		System.out.println(">>>>>>>>>>>>수정처리완료 확인");
		
		Optional<GoodsEntity> result= repo.findById(gno);
		if(result.isPresent()) {
			GoodsEntity entity=result.get();
			entity.update(dto);
			repo.save(entity);
		}
	}
	//삭제
	@Override
	public void delete(long gno) {
		repo.deleteById(gno);
		
	}
	
	//admin회원리스트
	@Override
	public void findAll(Model model) {
		List<MemberListInsertDTO> result = mrepo.findAll().stream()
				.map(MemberListInsertDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
		
	}
}
