package ar.com.educacionit.bootcamp.connectors.meli.dto;

import java.util.List;
import jakarta.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "domain_id", "domain_name", "category_id", "category_name", "attributes" })
@Generated("jsonschema2pojo")
public class Auto {

	@JsonProperty("domain_id")
	private String domainId;
	@JsonProperty("domain_name")
	private String domainName;
	@JsonProperty("category_id")
	private String categoryId;
	@JsonProperty("category_name")
	private String categoryName;
	@JsonProperty("attributes")

	private List<Object> attributes;

	@JsonProperty("domain_id")
	public String getDomainId() {
		return domainId;
	}

	@JsonProperty("domain_id")
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	@JsonProperty("domain_name")
	public String getDomainName() {
		return domainName;
	}

	@JsonProperty("domain_name")
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@JsonProperty("category_id")
	public String getCategoryId() {
		return categoryId;
	}

	@JsonProperty("category_id")
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@JsonProperty("category_name")
	public String getCategoryName() {
		return categoryName;
	}

	@JsonProperty("category_name")
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("attributes")
	public List<Object> getAttributes() {
		return attributes;
	}

	@JsonProperty("attributes")
	public void setAttributes(List<Object> attributes) {
		this.attributes = attributes;
	}

}