package dev.trend.domain.post.repository;

import dev.trend.domain.news.repository.NewsRepository;
import dev.trend.domain.post.entity.Post;
import dev.trend.util.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import java.time.LocalDateTime;
import java.util.*;

public class PostRepository {

    private static Logger logger = LogManager.getLogger(NewsRepository.class);

    public List<Post> findAll() {
        // 조회 SQL
        final String selectQuey = "SELECT * FROM Post";

        List<Post> posts = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuey)) {

            while (resultSet.next()) {
                Long postId = resultSet.getLong("post_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Long memberId = resultSet.getLong("member_id");
                LocalDateTime publishDate = resultSet.getTimestamp("created_at") != null
                        ? resultSet.getTimestamp("created_at").toLocalDateTime()
                        : null;
                Long views = resultSet.getLong("views");

                posts.add(new Post(postId, title, content, memberId, views,publishDate));
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Post save(Post post) {
        final String insertQuery = "INSERT INTO post (title, content) VALUES (?, ?)";

        try (Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
             PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, post.getTitle());
            statement.setString(2, post.getContent());



            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (var generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        post.setPostId(generatedKeys.getLong(1)); // 자동 생성된 ID 가져오기
                    }
                }
            }

            logger.info("게시글 저장 완료: " + post.getPostId());
            return post;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 저장 실패", e);
        }
    }

    public Long updateById(Long postId, String title, String content) {
        final String updateQuery = "UPDATE post SET title = ?, content = ? WHERE post_id = ?";

        try (Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {


            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, postId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                logger.info("게시글 수정 완료 (postId: " + postId + ")");
                return postId;
            } else {
                logger.warn("수정할 게시글이 존재하지 않음 (postId: " + postId + ")");
                throw new IllegalArgumentException("게시글을 찾을 수 없습니다: ID = " + postId);
            }

        } catch (SQLException e) {
            logger.error("게시글 수정 실패 (postId: " + postId + ")", e);
            throw new RuntimeException("게시글 수정 실패", e);
        }
    }


    public void deleteById(Long postId) {
        final String deleteQuery = "DELETE FROM post WHERE post_id = ?";

        try (Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setLong(1, postId);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                logger.info("게시글 삭제 완료 (postId: " + postId + ")");
            } else {
                logger.warn("삭제할 게시글이 존재하지 않음 (postId: " + postId + ")");
            }

        } catch (SQLException e) {
            logger.error("게시글 삭제 실패 (postId: " + postId + ")", e);
            throw new RuntimeException("게시글 삭제 실패", e);
        }
    }

    public Optional<Post> findById(Long postId) {
        final String selectQuery = "SELECT * FROM post WHERE post_id = ?";

        try (Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            statement.setLong(1, postId); // 파라미터를 동적으로 바인딩

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    String content = rs.getString("content");

                    // 🛠 postId도 포함하여 객체 생성
                    Post post = new Post(postId, title, content);
                    return Optional.of(post);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 🛠 게시글을 찾지 못했을 경우 null 대신 Optional.empty() 반환
        return Optional.empty();
    }


}
