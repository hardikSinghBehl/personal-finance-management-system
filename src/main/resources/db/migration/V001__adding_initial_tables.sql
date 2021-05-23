CREATE TABLE users(
  id UUID PRIMARY KEY,
  email_id CHARACTER VARYING (50) NOT NULL UNIQUE,
  password CHARACTER VARYING (150) NOT NULL,
  first_name CHARACTER VARYING (50) NOT NULL,
  last_name CHARACTER VARYING (50) NOT NULL,
  date_of_birth TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE total_balances(
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT total_balances_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE balance_modes(
  id UUID PRIMARY KEY,
  total_balance_id UUID NOT NULL,
  mode_type CHARACTER VARYING(30) NOT NULL,
  name CHARACTER VARYING (50) NOT NULL,
  value DECIMAL NOT NULL,
  is_active BOOLEAN NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT balance_modes_fkey_total_balance FOREIGN KEY (total_balance_id)
        REFERENCES total_balances (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE completed_tickets(
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  balance_mode_id UUID NOT NULL,
  name CHARACTER VARYING (50) NOT NULL,
  description CHARACTER VARYING (500) NOT NULL,
  ticket_type CHARACTER VARYING (10) NOT NULL,
  value DECIMAL NOT NULL,
  ticket_completion_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT completed_tickets_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
  CONSTRAINT completed_tickets_fkey_balance_mode FOREIGN KEY (balance_mode_id)
        REFERENCES balance_modes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION        
);

CREATE TABLE future_tickets(
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  balance_mode_id UUID NOT NULL,
  name CHARACTER VARYING (50) NOT NULL,
  description CHARACTER VARYING (500) NOT NULL,
  ticket_type CHARACTER VARYING (10) NOT NULL,
  value DECIMAL NOT NULL,
  ticket_completion_date TIMESTAMP WITHOUT TIME ZONE,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT future_tickets_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
  CONSTRAINT future_tickets_fkey_balance_mode FOREIGN KEY (balance_mode_id)
        REFERENCES balance_modes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION        
);

CREATE TABLE financial_goals(
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  title CHARACTER VARYING (100) NOT NULL,
  description CHARACTER VARYING (1000) NOT NULL,
  is_active BOOLEAN NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT financial_goals_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE financial_notes(
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL,
  title CHARACTER VARYING (100) NOT NULL,
  description CHARACTER VARYING (1000) NOT NULL,
  is_active BOOLEAN NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT financial_notes_fkey_user FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE master_tags(
  id SERIAL PRIMARY KEY,
  name CHARACTER VARYING (50) NOT NULL UNIQUE,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE note_tag_mappings(
  id SERIAL PRIMARY KEY,
  tag_id INTEGER NOT NULL,
  note_id UUID NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  UNIQUE (tag_id, note_id),
  CONSTRAINT note_tag_mappings_fkey_tags FOREIGN KEY (tag_id)
        REFERENCES master_tags (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
  CONSTRAINT note_tag_mappings_fkey_note FOREIGN KEY (note_id)
        REFERENCES financial_notes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION  
);

CREATE TABLE ticket_tag_mappings(
  id SERIAL PRIMARY KEY,
  tag_id INTEGER NOT NULL,
  ticket_type CHARACTER VARYING (20) NOT NULL,
  ticket_id UUID NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT ticket_tag_mappings_fkey_tags FOREIGN KEY (tag_id)
        REFERENCES master_tags (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
