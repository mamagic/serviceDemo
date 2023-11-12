package chat.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ChatDto {
    private long roomId;
    private long userId;
    private String message;
    private String time;
    private boolean isFirst;
    private int userProfile;
}
