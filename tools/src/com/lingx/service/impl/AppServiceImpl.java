package com.lingx.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.lingx.service.IAppService;
import com.lingx.service.IImageService;

public class AppServiceImpl implements IAppService {
	private IImageService imageService;
	private String sourcePath;
	private String targetPath;
	@Override
	public void handler(String[] args) {
		File source=new File(sourcePath);
		File target=new File(targetPath);
		if(!target.exists()){
			target.mkdirs();
		}
		File files[]=source.listFiles();
		for(File file:files){
			if(file.isFile()){
				try {
					this.imageService.readImage(new FileInputStream(file));
					this.imageService.resize();
					this.imageService.writeImage(new FileOutputStream(new File(this.targetPath+File.separator+file.getName())));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}
	public void setImageService(IImageService imageService) {
		this.imageService = imageService;
	}
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

}
