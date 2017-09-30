package com.dragon.mugloar.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author gusciarv
 */
@Getter
@Setter
@ToString
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherReport {

    private Date time;
    private String code;
    private String message;
    @XmlElement(name = "varX-Rating")
    private Integer varXRating;
    private Coords coords;
}
