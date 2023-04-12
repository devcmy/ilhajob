package com.itwill.ilhajob.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.entity.Cv;
import com.itwill.ilhajob.user.repository.CvRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService{

	private final CvRepository cvRepository;
	private final ModelMapper modelMapper;

	@Override
	public CvDto saveCv(CvDto cvDto) {
		Cv cv = modelMapper.map(cvDto, Cv.class);
		cvRepository.save(cv);
		return modelMapper.map(cv,CvDto.class);
	}

	@Override
	public void removeById(Long id) {
		cvRepository.deleteById(id);
	}

	@Override
	public CvDto findCvById(Long id) {
		Optional<Cv> cv = cvRepository.findById(id);
		return modelMapper.map(cv, CvDto.class);
	}

	@Override
	public List<CvDto> findCvByUser(Long id) {
		List<Cv> cvList = cvRepository.findById(id).get().getUser().getCvList();
//		List<Cv> cvList = cvRepository.findById(id).orElse(null).getUser().getCvList();
		return cvList.stream().map(cv -> modelMapper.map(cv, CvDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CvDto> findCvAll() {
		List<Cv> cvList = cvRepository.findAll();
		return cvList.stream().map(cv -> modelMapper.map(cv, CvDto.class)).collect(Collectors.toList());
	}
}