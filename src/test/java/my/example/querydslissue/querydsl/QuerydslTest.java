package my.example.querydslissue.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import my.example.querydslissue.config.JPATestConfig;
import my.example.querydslissue.domain.QBoard;
import my.example.querydslissue.domain.QComment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static my.example.querydslissue.domain.QBoard.board;
import static my.example.querydslissue.domain.QComment.comment;

@DataJpaTest
@Import({JPATestConfig.class})
public class QuerydslTest {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    @DisplayName("querydsl with where fetch join")
    void querydsl_with_where_fetch_join() {
        jpaQueryFactory.selectFrom(board)
                .leftJoin(board.comment, comment).fetchJoin()
                .fetch();
    }
}
