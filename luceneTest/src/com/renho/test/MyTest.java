package com.renho.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateIndex() throws IOException, ParseException {

		long start = new Date().getTime();

		Analyzer analyzer = new StandardAnalyzer();

		Directory directory = FSDirectory.open(new File("h:/lucene/catalina.out_index").toPath());
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		config.setRAMBufferSizeMB(48);
		IndexWriter iwriter = new IndexWriter(directory, config);
		String data = readLine();
		while(null != data) {
			Document doc = new Document();
			doc.add(new Field("fieldname", data, TextField.TYPE_STORED));
			iwriter.addDocument(doc);
			data = readLine();
		}
		br.close();
		iwriter.close();
		long endIndexFile = new Date().getTime();
		
		System.out.println("创建索引时间:" + (endIndexFile - start));
		
		directory.close();
	}

	private String filePath = "h:/lucene/catalina.out";
	File file = new File(filePath);
	BufferedReader br = null;

	private String readLine() throws IOException {
		if(null == br) {
			br = new BufferedReader(new FileReader(file));
		}
		String temp = br.readLine();
		return temp;
	}
	
//	@Test()
	public void testSearch() throws IOException, ParseException {
		Directory directory = FSDirectory.open(new File("h:/lucene/catalina.out_index").toPath());
		Analyzer analyzer = new StandardAnalyzer();
		DirectoryReader ireader = DirectoryReader.open(directory);
		IndexSearcher isearcher = new IndexSearcher(ireader);
		// Parse a simple query that searches for "text":
		QueryParser parser = new QueryParser("fieldname", analyzer);
		Query query = parser.parse("本次初始化任务结束");
		ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		System.out.println(hits.length);
		// Iterate through the results:
		
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = isearcher.doc(hits[i].doc);
			System.out.println("This is the text to be indexed." + hitDoc.get("fieldname"));
		}
		 
		ireader.close();
		directory.close();
	}
}
