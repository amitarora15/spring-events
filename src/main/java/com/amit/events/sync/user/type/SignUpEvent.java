package com.amit.events.sync.user.type;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class SignUpEvent<T> {

    @NonNull
    private String name;

    private T message;

    @NonNull
    private Boolean isSuccess;

}
