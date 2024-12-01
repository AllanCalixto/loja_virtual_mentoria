SELECT CONSTRAINT_NAME FROM information_schema.constraint_column_usage WHERE TABLE_NAME = 'usuarios_acessos'
AND COLUMN_NAME = 'acesso_id' AND CONSTRAINT_NAME <> 'unique_acesso_user';