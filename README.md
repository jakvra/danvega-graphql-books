# GraphQL Books

This is an example of using Spring Data JPA + GraphQL mutations. 

```graphql
query findAllBooks {
    findAllBooks {
        id
        title
        pages
        author
        reviews {
            id
        }
    }
}

mutation create {
    createBook(title: "My new Book", pages: 99, author: "JVR") {
        id
        title
        pages
        author
    }
}

mutation addBook {
    addBook(book: {title: "My second Book", pages: 200, author: "JVR"}) {
        id
        title
        pages
        author
    }
}

mutation batchBook {
    batchCreate(books:[
        {title: "My 1 Book", pages: 111, author: "JVR1"},
        {title: "My 2 Book", pages: 222, author: "JVR2"},
        {title: "My 3 Book", pages: 333, author: "JVR3"},
        {title: "My 4 Book", pages: 444, author: "JVR4"},
        {title: "My 4 Book", pages: 555, author: "JVR5"}
    ]){
        id
        title
        pages
        author
    }
}
```