package com.user.service.UserService.entities;

import lombok.*;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;

//    @Min(value = 0, message = "Rating must be at least 0")
//    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;
    private String feedback;
    private Hotel hotel;

}


