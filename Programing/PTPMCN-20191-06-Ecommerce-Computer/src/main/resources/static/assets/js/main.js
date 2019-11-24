//document.addEventListener("DOMContentLoaded", () => {
//	const deletes = document.querySelectorAll(".delete");
//	deletes.forEach(del => {
//		console.log(del);
//		del.addEventListener("click", () => {
//			axios.delete(`/admin/customer/${del.id}/delete`)
//			.then((data) => {
//				console.log(data.data);
//				location.reload();
//			}).catch(error => {
//				console.log(error);
//			});
//		});
//	});
//});