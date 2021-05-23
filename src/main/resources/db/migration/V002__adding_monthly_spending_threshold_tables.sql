CREATE TABLE current_monthly_spending_threshold_limits(
  id SERIAL PRIMARY KEY,
  user_id UUID NOT NULL,
  limit_value DECIMAL NOT NULL,
  is_active BOOLEAN NOT NULL,
  CONSTRAINT monthly_spending_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE spending_threshold_records(
  id SERIAL PRIMARY KEY,
  user_id UUID NOT NULL,
  limit_value DECIMAL NOT NULL,
  value_spent DECIMAL NOT NULL,
  month CHARACTER VARYING (10) NOT NULL,
  year CHARACTER VARYING (4) NOT NULL,
  CONSTRAINT spending_threshold_records_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
