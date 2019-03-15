# VolleyTutorial
Sample Android Project using volley library

**Volley**

Volley is an HTTP library that makes networking for Android apps easier and most importantly, faster. volley offers some benefits like:

1.Automatic scheduling of network requests.


2.Multiple concurrent network connections.


3.Transparent disk and memory response caching with standard HTTP [cache coherence](https://en.wikipedia.org/wiki/Cache_coherence).


4.Support for request prioritization.


5.Cancellation request API. You can cancel a single request, or you can set blocks or scopes of requests to cancel.


6.Ease of customization, for example, for retry and backoff.


7.Strong ordering that makes it easy to correctly populate your UI with data fetched asynchronously from the network.


8.Debugging and tracing tools.

Required dependency :compile 'com.android.volley:volley:1.1.1'

Volley is a great choice as it runs network operations asynchronously by default, and can handle request queuing and cancellation 
simply and effectively  [parsing json data using volley library](https://www.thorntech.com/2016/03/parsing-json-android-using-volley-library/).


**RecyclerView and Adapter**

Adapters provide a binding from an app-specific data set to views that are displayed within a RecyclerView.n the RecyclerView model,
several different components work together to display your data. The overall container for your user interface is a RecyclerView object that
you add to your layout.The view holder objects are managed by an adapter, which you create by extending RecyclerView.Adapter [recyclerview](https://developer.android.com/guide/topics/ui/layout/recyclerview).


**Picasso**

Displaying images is easiest using a third party library such as Picasso from Square which will download and cache remote images and 
abstract the complexity behind an easy to use DSL.

Dependency to add Picasso:
    implementation 'com.squareup.picasso:picasso:2.5.2'
    
    
**Intents**


An Intent is a simple message object that is used to communicate between android components such as activities, content providers, 
broadcast receivers and services. Intents are also used to transfer data between activities. Intents are used generally for starting 
a new activity using startActivity().


