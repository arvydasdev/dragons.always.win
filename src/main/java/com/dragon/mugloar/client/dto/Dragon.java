package com.dragon.mugloar.client.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author gusciarv
 */
@Getter
@Setter
@ToString
@XmlRootElement
@JsonRootName(value = "dragon")
public class Dragon implements Serializable {

   private int scaleThickness;
   private int clawSharpness;
   private int wingStrength;
   private int fireBreath;
}
