<%@ include file="/WEB-INF/includes/header.jsp"%>
<div id="wrap">
	<div id="main" class="container clear-top" data-ng-controller="noteController">
	
		
			
					<div class="panel panel-primary">
						<div class="panel-heading">Sort and Filter Notes</div>
				
					
					<div class="panel-body color_cream">
						<p>This page is developed using AngulsrJS. noteController.js call noteService.js, 
						and noteService.js use $http method to ajax call form NoteController.class for 
						JSON data. Table is populated using this JSON data.</p>
					</div>	
					
					<div class="panel-body">
						
					
			    		<table class="table table-bordered note_tableSF">
			    			
						    <thead>
						      <tr>
						        <th data-ng-click="doSort('title')">Title <span class="glyphicon glyphicon-sort color_blue"></span></th>
						        <th  data-ng-click="doSort('content')">Content <span class="glyphicon glyphicon-sort color_blue"></span></th>
						      </tr>
						    </thead>
						    <tbody>
						     <tr>
						     <td><input type="text" data-ng-model="noteFilter.title" placeholder="Search by title" /></td>
						     <td><input type="text" data-ng-model="noteFilter.content" placeholder="Search by content"/></td>
						     
						     </tr>
							<tr data-ng-repeat="note in notes | filter:noteFilter | filter:content | orderBy:sortBy:reverse">
					                <td>{{note.title}}</td>
							        <td>{{note.content}}</td>
							        
            				</tr>
							
						    </tbody>
						  </table>
			    		
			  		</div>
				
			</div> <!-- End of Panel -->
		
		
	</div>
</div>


<%@ include file="/WEB-INF/includes/footer.jsp"%>
