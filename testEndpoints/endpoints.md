
## UserController

### POST: /login

#### loginInput.json

```
{
  "username": "admin",
  "password": "Almafa1"
}
```

### POST: /register

#### registerInput.json

```
{
  "email": "test@gmail.com",
  "username": "test",
  "password": "Almafa1",
  "confirmPassword": "Almafa1"
}
```

#### response: the created user

```
{
    "id": 4,
    "username": "test",
    "role": "ROLE_STOREMAN"
}
```

### POST: /changeRole

#### roleInput.json

```
{
	"userId": "3",
	"role": "ROLE_STOREKEEPER"
}
```

#### response: the edited user

```
{
    "id": 3,
    "username": "storeman",
    "role": "ROLE_STOREKEEPER"
}
```


## ProductController

### POST: /product/add

#### productInput.json

```
{
    "name": "Product6",
    "price": 100,
    "quantity": 60
}
```

#### response: the created product

```
{
    "id": 1,
    "name": "Product6",
    "price": 100.0,
    "status": "ON_HOLD",
    "quantity": 60
}
```

### POST: /product/changeStatus

#### productStatusInput.json

```
{
    "productId" : 1,
	"status": "ON_SALE"
}
```

#### response: the edited product

```
{
    "id": 1,
    "name": "Product6",
    "price": 100.0,
    "status": "ON_SALE",
    "quantity": 60
}
```

### GET: /product/getAll

#### response: the products

```
[
    {
        "id": 1,
        "name": "Product6",
        "price": 100.0,
        "status": "ON_SALE",
        "quantity": 60
    },
    {
        "id": 2,
        "name": "Product6",
        "price": 100.0,
        "status": "ON_HOLD",
        "quantity": 60
    }
]
```

### POST: /product/search


#### searchParams.json

```
{
    "productStatus": "ON_SALE"
}
```
- Also works for: productName and productClassName

#### response: the products

```
[
    {
        "id": 1,
        "name": "Product6",
        "price": 100.0,
        "status": "ON_SALE",
        "quantity": 60
    }
]
```

## OrderController

### POST: /order/add

#### orderInput.json

```
{
	"name": "testOrder1",
	"petitionerId": 3,
	"evaluatorId": 1,
	"productId": 1,
	"quantity": 1000
}
```

#### response: the created order

```
{
    "id": 1,
    "petitionerId": 3,
    "evaluator": {
        "id": 1,
        "username": "admin",
        "role": "ROLE_ADMIN"
    },
    "product": {
        "id": 1,
        "name": "Product5",
        "price": 100.0,
        "status": "ON_HOLD",
        "quantity": 50
    },
    "totalPrize": 100000.0,
    "quantity": 1000,
    "status": "NOT_EVAULATED"
}
```
### POST: /order/changeStatus

#### orderStatusInput.json

```
{
	"orderId" : 1,
	"status": "ACCEPTED"
}
```

#### response: the edited order

```
{
    "id": 1,
    "petitionerId": 3,
    "evaluator": {
        "id": 1,
        "username": "admin",
        "role": "ROLE_ADMIN"
    },
    "product": {
        "id": 1,
        "name": "Product5",
        "price": 100.0,
        "status": "ON_HOLD",
        "quantity": 1050
    },
    "totalPrize": 100000.0,
    "quantity": 1000,
    "status": "ACCEPTED"
}
```

## ProductClassController

### POST: /productClass/add

#### productClassInput.json

```
{
	"name":"testClass"
}
```

#### response: the created class

```
{
    "id": 1,
    "name": "testClass"
}
```

### POST: /productClass/product/add

#### productClassProductInput.json

```
{
	"productClassId": 1,
	"productId": 1
}
```

#### response: the edited class

```
{
    "id": 1,
    "name": "testClass"
}
```


### GET : /productClass/getAll

#### response: 

```
[
    {
        "id": 1,
        "name": "testClass"
    },
    {
        "id": 2,
        "name": "testClass2"
    }
]
```

### GET: /productClass/products/{class_id}

#### response: the products in the class

```
[
    {
        "id": 1,
        "name": "Product6",
        "price": 100.0,
        "status": "ON_SALE",
        "quantity": 60
    },
    {
        "id": 2,
        "name": "Product6",
        "price": 100.0,
        "status": "ON_HOLD",
        "quantity": 60
    }
]
```









