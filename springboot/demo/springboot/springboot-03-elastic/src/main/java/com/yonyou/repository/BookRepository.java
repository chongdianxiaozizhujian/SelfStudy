package com.yonyou.repository;

import com.yonyou.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer>{
}
