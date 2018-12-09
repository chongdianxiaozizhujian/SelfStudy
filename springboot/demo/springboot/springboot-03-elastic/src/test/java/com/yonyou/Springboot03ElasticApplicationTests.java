package com.yonyou;

import com.yonyou.bean.Article;
import com.yonyou.bean.Book;
import com.yonyou.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void contextLoads() {
		Article article = new Article();
		article.setId(1);
		article.setAuthor("罗贯中");
		article.setTitle("东汉末年分三国");
		article.setContent("群雄涿鹿,谁主沉浮");
		Index index = new Index.Builder(article).index("yonyou").type("news").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searche() {
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"雄\"\n" +
				"        }\n" +
				"    }\n" +
				"}";

		Search search = new Search.Builder(json).addIndex("yonyou").addType("news").build();
		try {
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		Book book = new Book();
		book.setId(1);
		book.setAuthor("罗贯中");
		book.setBookName("三国演义");
		bookRepository.index(book);
	}

}
