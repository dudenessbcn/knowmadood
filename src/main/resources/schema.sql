create table if not exists PRICES (
    BRAND_ID bigint not null,
    START_DATE TIMESTAMP not null,
    END_DATE TIMESTAMP not null,
    PRICE_LIST bigint not null,
    PRODUCT_ID bigint not null,
    PRIORITY bigint not null,
    PRICE double not null,
    CURR varchar(10) not null
);