package com.lingx.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IImageService {

	public void readImage(InputStream inputStream) throws IOException;
	public void resize();
	public void writeImage(OutputStream outputStream)throws IOException;
}
