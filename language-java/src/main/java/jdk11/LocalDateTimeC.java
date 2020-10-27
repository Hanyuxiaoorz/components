package jdk11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * {@link java.time.LocalDateTime}
 */
public class LocalDateTimeC {

    /**
     * 把 {@link LocalDateTime} 转换为 {@link Date}
     */
    public void toDate(LocalDateTime localDateTime) {
        Date date = Date.from(localDateTime
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 把 {@link Date} 转换为 {@link LocalDateTime}
     */
    public void of(Date date) {
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
