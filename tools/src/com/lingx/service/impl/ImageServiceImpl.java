package com.lingx.service.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.lingx.service.IImageService;
import com.lingx.service.IScriptService;

public class ImageServiceImpl implements IImageService {

	private BufferedImage bufferedImage;
	private String formatName;
	private IScriptService scriptService;
	private String widthScript;
	private String heightScript;

	public ImageServiceImpl() {
		this.formatName = "png";
		this.widthScript="width/3*2";
		this.heightScript="height/3*2";
	}

	public void readImage(InputStream inputStream) throws IOException {
		bufferedImage = ImageIO.read(inputStream);
		if(inputStream!=null)inputStream.close();
	}
	/**
	 * g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //图形抗锯齿
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //字体抗锯齿
	 */
	public void resize() {
		int w, h;
		this.initScriptTools();
		w=Double.valueOf(this.scriptService.exe(this.widthScript).toString()).intValue() ;
		h=Double.valueOf(this.scriptService.exe(this.heightScript).toString()).intValue();
		BufferedImage _image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d =_image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//图形抗锯齿
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //字体抗锯齿
		g2d.drawImage(this.bufferedImage.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null);  
		//g2d.drawImage(bufferedImage, 0, 0, w, h, null);
		this.bufferedImage = _image;
	}
	private void initScriptTools(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("width", this.bufferedImage.getWidth());
		map.put("height", this.bufferedImage.getHeight());
		this.scriptService.init(map);
	}

	public void writeImage(OutputStream outputStream) throws IOException {
		ImageIO.write(bufferedImage, formatName, outputStream);
		if(outputStream!=null)outputStream.close();
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public void setWidthScript(String widthScript) {
		this.widthScript = widthScript;
	}

	public void setHeightScript(String heightScript) {
		this.heightScript = heightScript;
	}

	public void setScriptService(IScriptService scriptService) {
		this.scriptService = scriptService;
	}
}
