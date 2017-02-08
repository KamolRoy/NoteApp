/**
 * Interact with all event related to note
 */
$(document).ready(function(){
	$(document).on('focus', '.data', function(){
		$this=$(this);
        $id=$this.closest('tr').attr('id').split("_");
        $id=$id[1];
        
        $thisField=$this.attr('name');
        
        if ($thisField=="title") {
            $otherField="content";
        }
        if ($thisField=="content") {
            $otherField="title";
        }
        
        $thisText=$('tr#note_' + $id + ' .data[name="' + $thisField + '"]').val();
        $otherText=$('tr#note_' + $id + ' .data[name="' + $otherField + '"]').val();
        
        $this.on('focusout', function(){
        	$newText=$this.val();
        	if($newText!=$thisText){
        		
        		$.ajax({
        			type: "POST",
        			//url: '<c:url value='/updateNote'/>',
        			url: "/updateNote",
        			data: JSON.stringify({
        				"id": $id,
        				"thisField" : $thisField,
        				"thisText" : $newText,
        			}), // End of data
        			'beforeSend': function(){
        				 $('div#dnote_'+ $id).removeClass('delete glyphicon glyphicon-remove').addClass('loader_small');
        			}, // End of send before
        			"success": function(){
        				$('div#dnote_'+ $id).removeClass('loader_small').addClass('glyphicon glyphicon-ok color_green');
        				
        				
        				 $(document).on ('mouseover', '.note_table .glyphicon-ok' , function(){
                             $('.note_table .glyphicon-ok').removeClass('glyphicon glyphicon-ok color_green').addClass('delete glyphicon glyphicon-remove');
                                 }); // End of mouse over
        			}, // End of success
        			"error": function(e){
        				console.log(e);
        			},
        			contentType: "application/json",
        			dataType: "json"
        		});
        		
        		console.log($newText);
        	}
        });
        
        
	});
	$(document).on('click', '.delete', function(){
		$this=$(this);
        $id=$this.attr('id').split('_');
        $id=$id[1];
        
        $.ajax({
			type: "POST",
			//url: '<c:url value='/updateNote'/>',
			url: "/deleteNote",
			data: JSON.stringify({
				"id": $id,
			}),
			"success": function(){
				$('tr#note_' + $id).remove();
				console.log("done");
			},
			"error": function(e){
				console.log(e);
			},
			contentType: "application/json",
			dataType: "json"
		});
        
		console.log($id);
	});
	$(document).on('click', '.add', function(){
		
			$title=$('input.newdata[name="title"]').val();
			$content=$('input.newdata[name="content"]').val();
		
        
        $.ajax({
			type: "POST",
			//url: '<c:url value='/updateNote'/>',
			url: "/saveNote",
			data: JSON.stringify({
				"title": $title,
				"content": $content
			}),
			"success": function(data){
				$id = data.target;
				$output = "<tr id='note_" + $id + "'>";
                $output += "<td><input class='data' type='text' name='title' value='" + $title + "'></td>";
                $output += "<td><input class='data' type='text' name='content' value='" + $content + "'></td>";
                $output += "<td><div id='dnote_" + $id + "' class='delete glyphicon glyphicon-remove'></div></td>";
                $output += "</tr>";
                
                $('.note_table tr:last').before($output);
                
                $('input.newdata[name="title"]').val('');
                $('input.newdata[name="content"]').val('');
                
				console.log(data.target);
			},
			"error": function(e){
				console.log(e);
			},
			contentType: "application/json",
			dataType: "json"
		});
       
		console.log($title + " " + $content);
	});
});