CREATE TABLE URL_DETAIL (
	user_id text,
	shortend_url text,
	target_url text,
	is_active BOOLEAN,
	created_at date,
	modified_at date,
	
	PRIMARY KEY ((user_id,shortend_url), created_at)
)