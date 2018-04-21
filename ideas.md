Real quick ideas for how to update the objects within layers

### Scene
- Has a collection of layers
- Scene.update() -> for each layer in layers, layer.update()

### Layer
- Has a collection of layer objects
- For each layer object call layerObject.update(this)
	- unsure how to work around the asteroid with this
	- could maybe have a isWithin(bounds) for the asteroid at the top of the update functions and the asteroid object would be within all of the 
		- kinda nasty but it won't affect the play style 
			- means we can have layers that affect the asteroid that may not even be visible
			- such as a multiplier for gravity (gravity layer just multiplies the vector of the asteroid)

### LayerObject
- has an update(CloudLayer layer), update(SpaceLayer layer)
	- such that the object can change behaviour based on the layer that it is in
	- will have redundancy but can allow for further flexibility
	
	
#Some pseudocode
### Scene
	
```
public class Scene{
    Set<Layer> layers;
    // some constructor
    
    public void update(){
        // loop through layers
            // layer.update()
    }
}

```
	
### Layer
	
```
public interface Layer{ // maybe an abstract class with a default update() method, extending classes can override if they need
    void update();
}

```
	
	
### Concrete Layer
	
```
public class WindLayer implements Layer{
    Set<GameObject> objects;
    public void update(){
        // loop through game objects
            // object.update(this) // the specific layer
    }
}

```


### Layer Object
	
```
public interface LayerObject{
    update(WindLayer layer); // any object implementing this will define how the object behaves in a wind layer
    update(CoolLayerXD layer);
    update(Layyyeerrr layer);
}

```

### Concrete Layer Object
	
```
public class Asteroid implements LayerObject{
    int speedy;
    update(WindLayer layer){
        //update the speedy
    }
    update(CoolLayerXD layer){
        //do nothing???? XD
    }
    update(Layyyeerrr layer){
        //print("LAyerrrRR")
    }
}

```

