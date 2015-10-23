package com.renho.test.small;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmallTest {

	@Before
	public void setUp() throws Exception {
		/*String indexPath = "h://lucene/small/smallIndex";
		File file = new File(indexPath);
		File[] files = file.listFiles();
		for(File f:files) {
			f.delete();
		}
		file.delete();*/
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createIndex() throws IOException {
		String filePath = "h://lucene/small/small.txt";
		String indexPath = "h://lucene/small/smallIndex";
		Analyzer analyzer = new StandardAnalyzer();
//		Analyzer analyzer = new CJKAnalyzer();
//	    Analyzer analyzer = new ChineseAnalyzer();
//	    Analyzer analyzer = new WhitespaceAnalyzer();
		Directory directory = FSDirectory.open(new File(indexPath).toPath());
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		config.setRAMBufferSizeMB(48);
		IndexWriter iwriter = new IndexWriter(directory, config);

		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String str = br.readLine();
		while (null != str) {
			Document doc = new Document();
			doc.add(new Field("fieldname", str, TextField.TYPE_STORED));
			iwriter.addDocument(doc);
			str = br.readLine();
		}
		br.close();
		iwriter.close();
	}
	
	@Test
	public void search() throws IOException, ParseException {
		String indexPath = "h://lucene/small/smallIndex";
		Directory directory = FSDirectory.open(new File(indexPath).toPath());
		Analyzer analyzer = new StandardAnalyzer();
		DirectoryReader ireader = DirectoryReader.open(directory);
		IndexSearcher isearcher = new IndexSearcher(ireader);
		// Parse a simple query that searches for "text":
		QueryParser parser = new QueryParser("fieldname", analyzer);
		Query query = parser.parse("renho");
		ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		System.out.println(hits.length);
		// Iterate through the results:
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = isearcher.doc(hits[i].doc);
			System.out.println("This is the text to be indexed--->" + hitDoc.get("fieldname"));
		}
	}

}
