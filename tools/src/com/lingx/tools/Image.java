package com.lingx.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Image {

	private BufferedImage bufferedImage;
	private String formatName;
	private ScriptTools scriptTools;
	private String widthScript;
	private String heightScript;

	public Image() {
		this.formatName = "png";
		this.scriptTools=new ScriptTools();
		this.widthScript="width/3*2";
		this.heightScript="height/3*2";
	}

	public void readImage(InputStream inputStream) throws IOException {
		bufferedImage = ImageIO.read(inputStream);
		if(inputStream!=null)inputStream.close();
	}

	public void resize() {
		int w, h;
		this.initScriptTools();
		w=Double.valueOf(this.scriptTools.exe(this.widthScript).toString()).intValue() ;
		h=Double.valueOf(this.scriptTools.exe(this.heightScript).toString()).intValue();
		BufferedImage _image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		_image.getGraphics().drawImage(bufferedImage, 0, 0, w, h, null);
		this.bufferedImage = _image;
	}
	private void initScriptTools(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("width", this.bufferedImage.getWidth());
		map.put("height", this.bufferedImage.getHeight());
		this.scriptTools.init(map);
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
}
