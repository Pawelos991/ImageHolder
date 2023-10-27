DROP TABLE IF EXISTS public.image CASCADE
;

CREATE TABLE public.image
(
    id integer NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    filename varchar(255) NOT NULL,
    description text NOT NULL,
    base64 text NOT NULL
)
;

COMMENT ON TABLE public.image
    IS 'Tabela przechowująca obrazy'
;

COMMENT ON COLUMN public.image.id
    IS 'Klucz główny'
;
COMMENT ON COLUMN public.image.name
    IS 'Nazwa pozycji z obrazem'
;
COMMENT ON COLUMN public.image.filename
    IS 'Nazwa pliku obrazu'
;
COMMENT ON COLUMN public.image.description
    IS 'Opis pozycji'
;
COMMENT ON COLUMN public.image.base64
    IS 'Zawartość zdjęcia zakodowana w Base64'
;
