
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

## Other
- MVVM architecture with combination of Clean Architure is used
- Interface Segregation Principle : ListItemClickListener used only for click.
- Singletone design patterns mainly for injecting repo
- Contraintlayouts for optimized UI by enhancing the view hierachy


