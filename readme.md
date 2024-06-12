[BaarezTech.postman_collection.json](https://github.com/user-attachments/files/15811822/BaarezTech.postman_collection.json)
# Barez Tech - eCommerce Application (PoC)

This app loads images from the JSON file and display the images in grid of 3 items and the details about the images are shown when user clicks on the image.

## APIs Consumed

// products
- GET: get all products
- GET: get all categories
- GET: sort product results
- GET: get product in specific category
- GET: get single product
- GET: limit product results

// carts
- GET: get all carts
- GET: get single cart
- GET: limit cart results
- GET: get carts in date range
- GET: get user cart
- GET: sort cart results

## Package structure
The app is divided into three main packages
- data : To load the data. It contains all Repository's Impl and Viewmodels
- domain : It contains all models and usecases
- presentation or ui : It contains the UI i.e Activites, Fragments etc.

## Third party libraries Used
- Picasso for Image loading
- Hilt for dependecny Injection
- Gson for parsing json
- Retofit for networking

## Other
- MVVM architecture with combination of Clean Architure is used
- Interface Segregation Principle : ListItemClickListener used only for click.
- Singletone design patterns mainly for injecting repo
- Contraintlayouts for optimized UI by enhancing the view hierachy

## Design Ideation
![eCom-Poc-Design](https://github.com/pravingaikwad07/eComPoC/assets/13349805/de3fbd13-2e46-47fb-9c4b-dac84f2d6bdd)

## Postman collection for API reference
[Upload{
	"info": {
		"_postman_id": "3c06c20c-4931-49da-bf3f-d3ce8b13dc6e",
		"name": "BaarezTech",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "114350"
	},
	"item": [
		{
			"name": "dashboard",
			"item": [
				{
					"name": "get all products",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products"
							]
						}
					},
					"response": []
				},
				{
					"name": "get all categories",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products/categories",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products",
								"categories"
							]
						}
					},
					"response": []
				},
				{
					"name": "get product in specific category",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products/category/jewelery",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products",
								"category",
								"jewelery"
							]
						}
					},
					"response": []
				},
				{
					"name": "sort results",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products?sort=desc",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products"
							],
							"query": [
								{
									"key": "sort",
									"value": "desc"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "limit product results",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products?limit=5",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products"
							],
							"query": [
								{
									"key": "limit",
									"value": "5"
								}
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "cart",
			"item": [
				{
					"name": "get single cart",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts/5",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts",
								"5"
							]
						}
					},
					"response": []
				},
				{
					"name": "sort results",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts?sort=desc",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts"
							],
							"query": [
								{
									"key": "sort",
									"value": "desc"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "limit cart results",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts?limit=5",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts"
							],
							"query": [
								{
									"key": "limit",
									"value": "5"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "get carts in date range",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts?startdate=2019-12-10&enddate=2020-10-10",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts"
							],
							"query": [
								{
									"key": "startdate",
									"value": "2019-12-10"
								},
								{
									"key": "enddate",
									"value": "2020-10-10"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "get user cart",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts/user/1",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts",
								"user",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "get all carts",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/carts",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"carts"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "product",
			"item": [
				{
					"name": "get single product",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://fakestoreapi.com/products/1",
							"protocol": "https",
							"host": [
								"fakestoreapi",
								"com"
							],
							"path": [
								"products",
								"1"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}ing BaarezTech.postman_collection.json…]()



