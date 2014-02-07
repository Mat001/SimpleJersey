package com.simplejersey.repository;

import java.lang.String;
import java.io.*;

public class ReadFile
{
	private String path = "";
	private String text = "";

	// private static final String TEXTDOCUMENT = "textdocument.txt";

	// constructor
	public ReadFile(String path)
	{
		this.path = path;
	}

	// read text from file and store it into a string variable "text"
	public String readText()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null)
			{
				// store text in "text" variable
				text += line;
				line = reader.readLine(); // goes into the next line until the
											// while condition is met
			}
			reader.close();
		} catch (FileNotFoundException e)
		{
			System.err.println("Unable to open file.");
		} catch (IOException e)
		{
			System.err.println("Problem was encountered reading or closing the file.");
		}
		return text;
	}

}