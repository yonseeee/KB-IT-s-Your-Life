package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException{
//        기본 디렉토리가 있는지 확인, 없으면 새로 생성
        File base=new File(baseDir);
        if(!base.exists()){
            base.mkdirs();//중간에 존재하지 않는 디렉토리까지 모두 생성
        }
        String fileName=part.getOriginalFilename();
        File dest=new File(baseDir, UploadFileName.getUniqueName(fileName));
        part.transferTo(dest);//지정한 경로로 업로드 파일 이동
        return dest.getPath();//저장된 파일 경로 리턴
    }
}
