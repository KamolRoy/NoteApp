<%@ include file="/WEB-INF/includes/header.jsp"%>
<div id="wrap">
	<div id="main" class="container clear-top">
	
		
			
					<div class="panel panel-primary">
						<div class="panel-heading">Create, Update or Delete Note</div>
						
					<div class="panel-body color_cream">
						<p>This page is developed with JSTL. From MasterController, noteService retrieve the logged in user 
						notes and add it to model attribute. While the JSP load, it populate table using 
						JSTL core forEach function</p>
						
						<p>With user login, two note default added to that user.</p>
						
						<p>Click on the text value to update it. 
						Click the cross button to delete note and add note using bottom row.</p>
					</div>	
										
					<div class="panel-body">
			    		<table class="table table-bordered note_table">
			    			
						    <thead>
						      <tr>
						        <th>Title</th>
						        <th>Content</th>
						        <th>Add/Delete</th>
						      </tr>
						    </thead>
						    <tbody>
						    
						      <c:forEach var="rowNote" items="${notes }">
								<tr id="note_${rowNote.id}">
							        <td><input class="data" type="text" name="title" value="${rowNote.title }"></td>
							        <td><input class="data" type="text" name="content" value="${rowNote.content }"></td>
							        <td> 
							        	<div id='dnote_${rowNote.id}' class='delete glyphicon glyphicon-remove'></div>
							        </td>
							     </tr>
							</c:forEach>
						      <tr id="new_note">
							        <td><input class="newdata" type="text" name="title" placeholder="Add your title"></td>
							        <td><input class="newdata" type="text" name="content" placeholder="Add your content"></td>
							        <td> <button class="btn btn-success add" > Add </button></td>
							     </tr>
						    </tbody>
						  </table>
			    		
			  		</div>
				
		</div> <!-- End of Panel -->
		
		
	</div>
</div>


<%@ include file="/WEB-INF/includes/footer.jsp"%>
