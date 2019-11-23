//document.addEventListener("DOMContentLoaded", () => {
//	const deletes = document.querySelectorAll(".delete");
//	deletes.forEach(del => {
//		del.addEventListener("click", () => {
//			axios({
//				url: `/admin/customer/${del.id}/delete`,
//				method: "GET"
//			}).then((data) => {
//				console.log(data.data);
//				location.reload();
//			}).catch(error => {
//				console.log(error);
//			});
//		});
//	});
//});