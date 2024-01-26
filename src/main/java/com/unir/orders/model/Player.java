package com.unir.orders.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Player {
    private Long id;
    private String name;
    private String club;
    private String position;
    private int overall;
    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defending;
    private int physicality;
}
