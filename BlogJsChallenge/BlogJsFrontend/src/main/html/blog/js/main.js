var module = angular.module( 'blog', [ 'ngRoute' ] );
module.controller( 'BlogCtrl', [ '$http', '$location', '$route', '$sce', BlogCtrl ]);
module.config( BlogConfig );

function BlogConfig($routeProvider, $locationProvider){
    //$routeProvider.when( '/filters', { templateUrl: "/views/filters.html" } );
    $routeProvider.otherwise( { templateUrl: "/views/all-posts.html" } );
}

function BlogCtrl( $http, $location, $route, $sce ){
    var ctrl = this;
    ctrl.posts = [];
    
    function baseLocation(){
        var port = $location.port();
        
        if( port ){
            return $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/api/posts";
        } else {
            return $location.protocol() + "://" + $location.host() + "/api/posts";
        }
    };
    
    ctrl.loadAllPosts = function(){
        $http.get( baseLocation() ).success( loadAllPostsSuccess ).error( loadAllPostsError );
    }
    
    function loadAllPostsSuccess( data ){
        ctrl.posts = data['posts'];
        for( var i = 0; i < ctrl.posts.length; i++ ){
            var post = ctrl.posts[i];
            post.pullQuoteAsHtml = $sce.trustAsHtml( post.pullQuoteAsHtml );
            post.bodyAsHtml = $sce.trustAsHtml( post.bodyAsHtml );
        }
    }
    
    function loadAllPostsError( data, status, headers, config ){
        console.error( "Error loading posts" );
        console.error( data );
    }
    
    ctrl.toPrintableDate = function( date ){
        var months = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ];
        if( date ){
            try{
                var printable = new Date(date);
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
    
    ctrl.loadAllPosts();
}