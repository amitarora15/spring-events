package com.amit.events.db.order.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_table")
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private Long price;

    @Column
    @NonNull
    private String user;

    @Column
    private Boolean hasGoodiesAdded;

}
