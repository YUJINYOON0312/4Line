package com.green.nowon.domain.entity;

import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.green.nowon.domain.dto.admin.AdminUpdateDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_seq_good",
		sequenceName = "seq_good", initialValue = 1, allocationSize = 1)
@Table(name = "goods")
@Entity
public class GoodsEntity extends BaseDateEntity{
	
	@Id
	@GeneratedValue(generator = "gen_seq_good", strategy = GenerationType.SEQUENCE)
	private long gno;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false, columnDefinition = "text")
	private String content;
	private int price;
	private int stock;
	
	//양방향설정
	@JoinColumn(name = "gno")
	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<GoodsImg> imgs=new Vector<>();
	
	public String defImgUrl() {
		GoodsImg def=imgs.get(0);
		return def.getUrl()+def.getNewName();
	}
	
	//이미지 삽입 편의메서드
	public GoodsEntity addImg(GoodsImg gimg) {
		imgs.add(gimg);
		return this;
	}
	
	//대표이미지만 추출하는 편의메서드
	public GoodsImg defImg() {
		for(GoodsImg gimg:imgs) {
			if(gimg.isDef()==true)
				return gimg;
		}
		return null;
	}

	//goods update
	public GoodsEntity update(AdminUpdateDTO dto) {
//		dto.updateEntity();
		this.title=dto.getTitle();
		this.content=dto.getContent();
		this.price = dto.getPrice();
		this.stock = dto.getStock();
		return this;
	}
}