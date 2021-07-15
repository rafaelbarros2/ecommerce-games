package br.com.supera.game.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_productr")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;

   public String name;

   public BigDecimal price;

   public short score;

   public String image;
   
   @OneToMany(mappedBy = "id.product")
   private Set<OrderItem> items = new HashSet<>();
   
   @JsonIgnore
   public Set<Order> getOrders(){
	   Set<Order> set = new HashSet<>();
	   for(OrderItem x : items) {
		   set.add(x.getOrder());
	   }
	   return set;
   }

}