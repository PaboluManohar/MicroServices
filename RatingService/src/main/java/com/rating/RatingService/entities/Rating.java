package com.rating.RatingService.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("user_Ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;

    //    @Min(value = 0, message = "Rating must be at least 0")
//    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;
    private String feedback;
}