package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
//        기본 디렉토리가 있는지 확인, 없으면 새로 생성
        File base = new File(baseDir);
        if (!base.exists()) {
            base.mkdirs();//중간에 존재하지 않는 디렉토리까지 모두 생성
        }
        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));
        part.transferTo(dest);//지정한 경로로 업로드 파일 이동
        return dest.getPath();//저장된 파일 경로 리턴
    }

    public static String getFormatSize(Long size) {
//        파일 크기가 0 이하일 경우 "0" 반환
        if (size <= 0) return "0";

//        파일 크기를 나타낼 단위를 정의
        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};

//        파일 크기가 어느 단위에 속하는지 계산(KB, MB)
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));

//        vkdlf zmrlfmf rPtksehls eksdnlfh qusghksgkrh vhzotxldgkdu answkfh aqusghks
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void download(HttpServletResponse response, File file, String orgName) throws Exception{
        //헤더 설정

//        ㅇ응답의 ContentType을 다운로드 파일로 설정
        response.setContentType("application/download");
//       파일의 크기를 응답에 설정
        response.setContentLength((int)file.length());

//        한글 파일명을 URL 인코딩(필수)
        String filename= URLEncoder.encode(orgName, "UTF-8");
//        응답 헤더에 파일 다운로드 정보를 설정
        response.setHeader("Content-disposition","attachment;filename=\""+filename+"\"");

//        Body 설정

//        파일을 클라이언트로 전송
        try(OutputStream os = response.getOutputStream();//자동 닫기 하기 위한 try
            BufferedOutputStream bos=new BufferedOutputStream(os)){
//            원본 파일을 스트림으로 전송(복사)
            Files.copy(Paths.get(file.getPath()), bos);
        }

    }
}
