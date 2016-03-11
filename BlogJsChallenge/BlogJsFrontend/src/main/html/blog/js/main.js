var module = angular.module( 'blog', [ 'ngRoute' ] );
module.controller( 'BlogCtrl', [ '$http', '$location', '$route', '$sce', BlogCtrl ]);
module.config( BlogConfig );

function BlogConfig($routeProvider, $locationProvider){
    //$routeProvider.when( '/filters', { templateUrl: "/views/filters.html" } );
    $routeProvider.when( '/view/:uuid', { templateUrl: "/views/post.html" } );
    $routeProvider.when( '/edit/:uuid', { templateUrl: "/views/edit-post.html" } );
    $routeProvider.otherwise( { templateUrl: "/views/all-posts.html" } );
}

function BlogCtrl( $http, $location, $route, $sce ){
    var ctrl = this;
    ctrl.posts = [];
    ctrl.post = {};
    
    /// API location ///
    
    function baseLocation(){
        var port = $location.port();
        
        if( port ){
            return $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/api/posts";
        } else {
            return $location.protocol() + "://" + $location.host() + "/api/posts";
        }
    };
    
    /// load posts ///
    
    ctrl.loadAllPosts = function(){
        $http.get( baseLocation() ).success( loadAllPostsSuccess ).error( loadAllPostsError );
    }
    
    function loadAllPostsSuccess( data ){
        ctrl.posts = data['posts'];
        for( var i = 0; i < ctrl.posts.length; i++ ){
            var post = ctrl.posts[i];
            trustPostHtml( post );
        }
    }
    
    function loadAllPostsError( data, status, headers, config ){
        console.error( "Error loading posts" );
        console.error( data );
    }
    
    /// load single post ///
    
    ctrl.showPost = function( uuid ){
        if( ctrl.loadingUuid !== uuid ){
            ctrl.loadingUuid = uuid;
            //console.log( "Loading " + uuid );
            
            var url = baseLocation() + "/" + uuid;
            $http.get( url ).success( loadPostSuccess ).error( loadPostError );
        }
//        else{
//            console.log( "Loading already in progress" );
//        }
    }
    
    function loadPostSuccess( post ){
        ctrl.loadingUuid = undefined;
        
        trustPostHtml( post );
        ctrl.post = post;
        
        $location.path( "/view/" + post.uuid );
    }
    
    function loadPostError( data, status, headers, config ){
        ctrl.loadingUuid = undefined;
        console.error( "Error loading post" );
        console.error( data );
    }
    
    ctrl.currentPost = function(){
        if( !ctrl.post.uuid ){
            //console.log( "Need to load post..." );
            
            var location = $location.path();
            var uuid = location.replace( "/view/", "" );
            ctrl.showPost(uuid);
        }
        return ctrl.post;
    }
    
    /// formatting ///
    
    function trustPostHtml( post ){
        post.pullQuoteAsHtml = $sce.trustAsHtml( post.pullQuoteAsHtml );
        post.bodyAsHtml = $sce.trustAsHtml( post.bodyAsHtml );
    }
    
    ctrl.toPrintableDate = function( date ){
        if( date ){
            try{
                var printable = new Date(date);
                var months = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ];
                
                var day = printable.getDay()+1;
                day = "" + day + ordinal(day);
                
                var month =  months[printable.getMonth()];
                var year = printable.getFullYear();
                
                return day + " " + month + ", " + year;
            }
            catch( error ){
                console.error( "Error generating date from: " + date );
                console.error( error );
            }
        }
        
        return "";
    }
    
    function ordinal( integer ){
        integer = integer % 10;
        
        if( integer == 1 ){
            return "st";
        }
        else if( integer == 2 ){
            return "nd";
        }
        else if( integer == 3 ){
            return "rd";
        }
        else{
            return "th";
        }
    }
    
    /// init ///
    
    function init(){
        ctrl.loadAllPosts();
    }
    init();
}