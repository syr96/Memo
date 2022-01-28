package com.yullmaster.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	public final String FILE_UPLOAD_PATH = "D:\\석유림\\springProject\\spring\\upload\\image/";
	// final 은 한번 세팅한 값은 절대 수정할 수 없게 해준다
	// final 로 만든 변수는 대문자로 만들어준다
	
	// 파일 저장
	public String saveFile(int userId, MultipartFile file) {
		
		// 파일경로
		// 사용자 별로 구분할 수 있도록
		// 사용자가 파일을 올린 시간 으로 구분
		// /12_13486461/test.png // _뒤에는 시간응 구분하는 숫자가 붙는다
		// 1970 년 1월 1일 기준으로 현지 밀리 세컨이 경과 되었는지 나타내는 수
		
		String directoryName = userId + "-" + System.currentTimeMillis() + "/";
		
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			// 디렉토리 생성 에러
			return null;
		}
		
		try {
			byte[] bytes = file.getBytes();
			
			// 파일 저장 경로 + 파일 이름 경로 객체
			Path path = Paths.get(filePath + file.getOriginalFilename());
			
			// 파일 저장
			Files.write(path, bytes);
		} catch (IOException e) {
			// 파일 저장 실패
			e.printStackTrace();
			return null;
		}
		
		// 파일 접근 가능한 주소 리턴
		// <img src="/images/12_1616303164/test.png">
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
	}
}
