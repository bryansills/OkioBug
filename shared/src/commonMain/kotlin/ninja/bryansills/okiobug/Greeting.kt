package ninja.bryansills.okiobug

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}