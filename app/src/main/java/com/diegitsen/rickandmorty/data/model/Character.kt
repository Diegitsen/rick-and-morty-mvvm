package com.diegitsen.rickandmorty.data.model

class Character(var id: Int, var name: String ,var status: String, var species: String, var gender: String, var image: String) {
}

/*


      class Repository(repositoryName : String, var repositoryOwner: String?, var numberOfStars: Int?
                 , var hasIssues: Boolean = false) : BaseObservable(){

    @get:Bindable
    var repositoryName : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }

}

 */