package com.green.nowon.service;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsImgService {


	Map<String,String> fileTempUpload(MultipartFile gimg);
}
