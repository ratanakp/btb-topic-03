package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.repositories.providers.BookProvider;
import com.example.demotopic03.utilities.Paginate;
import com.example.demotopic03.utilities.Pagination;
import com.example.demotopic03.utilities.filters.BookFilter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    @SelectProvider(type = BookProvider.class, method = "getAllProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "name", property = "category.name")
    })
    List<Book> getAll();


    @SelectProvider(type = BookProvider.class, method = "bookFilterProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "name", property = "category.name")
    })
    List<Book> bookFilter(BookFilter filter);




    @Select("select * from tb_book b inner join tb_category c ON b.cate_id = c.id where b.id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "name", property = "category.name")
    })
    Book findOne(@Param("id") Integer id);


    @Update("update tb_book set title=#{title}, author=#{author}, publisher=#{publisher}, thumbnail=#{thumbnail}, cate_id=#{category.id} where id=#{id}")
    boolean update(Book book);


    @Delete("delete from tb_book where id=#{id}")
    boolean delete(Integer id);

    @InsertProvider(type = BookProvider.class, method = "createProvider")
    @SelectKey(
            keyProperty = "id",
            keyColumn = "curr_id",
            statementType = StatementType.PREPARED,
            before = false,
            resultType = Integer.class,
            statement = "select currval('tb_book_id_seq') as curr_id"
    )
    boolean create(Book book);



    @Select("select count(*) from tb_book")
    Integer count();



    @Insert({
            "<script>" ,
                "insert into tb_book(title, author, publisher, thumbnail, cate_id) values" ,
                    "<foreach collection='books' item='book' index='ind_songleang' separator=','>(" ,
                        "#{book.title}",
                        ",#{book.author}",
                        ",#{book.publisher}",
                        ",#{book.thumbnail}",
                        ",#{book.category.id}",
                    ")</foreach>" ,
            "</script>"
    })
    boolean creates(@Param("books") List<Book> books);




    //all about pagination

    @SelectProvider(type = BookProvider.class, method = "countFilter")
    Integer countFilter(BookFilter bookFilter);

    /*
     *
     * TODO: get book filter with Pagination class
     *
     * */

    @SelectProvider(method = "getBookFilterPaginationProvider", type = BookProvider.class)
    @Results({
            @Result(column = "book_id", property = "id"),
            @Result(column = "book_title", property = "title"),
            @Result(column = "book_author", property = "author"),
            @Result(column = "book_publisher", property = "publisher"),
            @Result(column = "book_thumbnail", property = "thumbnail"),
            @Result(column = "category_id", property = "category.id"),
            @Result(column = "category_name", property = "category.name")
    })
    List<Book> getBookFilterPagination(@Param("bookFilter") BookFilter bookFilter,@Param("pagination") Pagination pagination);


    /*
     *
     * TODO: get book filter with Paginate class
     *
     * */

    @SelectProvider(method = "getBookFilterPaginateProvider", type = BookProvider.class)
    @Results({
            @Result(column = "book_id", property = "id"),
            @Result(column = "book_title", property = "title"),
            @Result(column = "book_author", property = "author"),
            @Result(column = "book_publisher", property = "publisher"),
            @Result(column = "book_thumbnail", property = "thumbnail"),
            @Result(column = "category_id", property = "category.id"),
            @Result(column = "category_name", property = "category.name")
    })
    List<Book> getBookFilterPaginate(@Param("bookFilter") BookFilter bookFilter,@Param("paginate") Paginate paginate);






    /*Faker faker = new Faker();



    List<Book> bookList = new ArrayList<>();

    {
        for (int i = 1; i < 11; i++) {
            Book book = new Book();

            book.setId(i);
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setPublisher(faker.book().publisher());
            bookList.add(book);
        }
    }


    public List<Book> getAll() {
        return this.bookList;
    }


    public Book findOne(Integer id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                return bookList.get(i);
            }
        }

        return null;
    }


    public boolean update(Book book) {

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == book.getId()) {
                bookList.set(i, book);
                return true;
            }
        }
        return false;
    }


    public boolean delete(Integer id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                bookList.remove(i);
                return true;
            }
        }

        return false;
    }


    public boolean create(Book book) {
        return bookList.add(book);
    }

*/
}
